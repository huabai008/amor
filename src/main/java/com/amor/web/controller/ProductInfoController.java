package com.amor.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amor.orm.model.AProduct;
import com.amor.orm.model.AProductImage;
import com.amor.service.ProductInfoService;
import com.github.pagehelper.PageInfo;

/**
 * 产品信息控制器
 * @author sicong.yang
 */
@Controller
@RequestMapping(value="/product")
public class ProductInfoController {
	
	@Resource
	private ProductInfoService productInfoSerivce;
	
	@RequestMapping(value="/")
	public String index(Model model, HttpServletRequest request) {
		try {
			Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
			model.addAttribute("typeMap", map);
			map = productInfoSerivce.getBusinessDict("product_silhouette");
			Map<String, String> smap = new HashMap<>();
			for (int idx : map.keySet()) {
				smap.put(String.valueOf(idx), map.get(idx));
			}
			model.addAttribute("silhouetteMap", smap);
			
			int pageNum = 1;
			int pageSize = 10;
			String pno = request.getParameter("pageNum");
			if (pno != null) {
				pageNum = Integer.parseInt(pno);
			}
			String psz = request.getParameter("pageSize");
			if (psz != null) {
				pageSize = Integer.parseInt(psz);
			}
			List<AProduct> prod_list = productInfoSerivce.queryProductByPage(pageNum, pageSize);
			Map<Integer, String> productImages = new HashMap<>();
			String imgOc = "assets/img/no-image.jpg";
			for (AProduct product : prod_list) {
				AProductImage image = productInfoSerivce.selectTopPriorityImage(product.getId());
				if (image != null) {
					productImages.put(product.getId(), image.getImgPath());
				} else {
					productImages.put(product.getId(), imgOc);
				}
			}
			model.addAttribute("prod_imgs", productImages);
			PageInfo<AProduct> page = new PageInfo<AProduct>(prod_list);
			model.addAttribute("page", page);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "product_main";
	}
	
	@RequestMapping(value="/record")
	public String record(Model model, HttpServletRequest request) {
		String page = request.getParameter("page");
		page = (page != null && page.length() > 0) ? page : "1";
		try {
			String[] dicts = {"trends", "silhouette", "neckline", "waistline", "sleeve", 
							  "color", "size", "type", "collar_stays", "cuff_words_type", 
							  "version", "placket"};
			for (String dict : dicts) {
				Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_"+dict);
				model.addAttribute(dict + "Map", map);
			}
			model.addAttribute("item_type", Integer.parseInt(request.getParameter("item_type")));
			model.addAttribute("page", page);
		} catch (Error e) {
			model.addAttribute("error", e);
		}
		return "record";
	}
	
	@RequestMapping(value="/edit")
	public String edit(Model model, HttpServletRequest request) {
		String page = request.getParameter("page");
		page = (page != null && page.length() > 0) ? page : "1";
		try {
			String[] dicts = {"silhouette", "neckline", "waistline", "sleeve", 
							  "color", "size", "type", "collar_stays", "cuff_words_type", 
							  "version", "placket"};
			Map<Integer, String> trendsMap = productInfoSerivce.getBusinessDict("product_trends");
			model.addAttribute("trendsMap", trendsMap);
			for (String dict : dicts) {
				Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_"+dict);
				model.addAttribute(dict + "Map", map);
			}
			String productID = request.getParameter("id");
			
			if (productID != null) {
				model.addAttribute("edit", 1);
				AProduct product = productInfoSerivce.selectProductByID(Integer.parseInt(productID));
				model.addAttribute("product", product);
				// get product images
				List<AProductImage> prod_imgs = productInfoSerivce.selectProductImageByID(Integer.parseInt(productID));
				model.addAttribute("prod_imgs", prod_imgs);
				
				Integer type = product.getItemType();
				if (product.getTrends() != null && (type == 0 || type == 1)) {
					Integer[] prod_trds = new Integer[trendsMap.size()];
					for (String key : product.getTrends().split(",")) {
						// TODO: trends dictionary id can only be continual
						prod_trds[Integer.parseInt(key)] = 1;
					}
					model.addAttribute("prod_trds", prod_trds);
				}
				model.addAttribute("productType", product.getItemType().toString());
				model.addAttribute("createDate", product.getCreateTime().getTime());
				return "record";
			} else {
				model.addAttribute("error", "ID parameter required!");
			}
		} catch (Error e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/rest/product/?pageNum=" + page + "&pageSize=10";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String submit(@Valid AProduct product, @Valid AProductImage prodImg, 
			HttpServletRequest request, Model model,
			@RequestParam("file") MultipartFile[] files) {
		Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
		model.addAttribute("typeMap", map);
		String page = request.getParameter("page");
		page = (page != null && page.length() > 0) ? page : "1";
		
		try {
			prepareData(product, request);
			int prodId = productInfoSerivce.insertProductInfo(product);
			
			prodImg.setProductId(prodId);
			String warningMsg = uploadFiles(prodImg, files);
			if (warningMsg.length() > 0) {
				model.addAttribute("warning", 1);
				model.addAttribute("FileUploadError", warningMsg);
			}

			model.addAttribute("success", 1);
            model.addAttribute("FileUploadError", warningMsg);
		} catch (Exception err) {
			model.addAttribute("success", 0);
			model.addAttribute("error", err.getMessage());
		}
		return "redirect:/rest/product/?pageNum=" + page + "&pageSize=10";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid AProduct product, @Valid AProductImage prodImg,
			HttpServletRequest request, Model model,
			@RequestParam("file") MultipartFile[] files) {
		Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
		model.addAttribute("typeMap", map);
		String page = request.getParameter("page");
		page = (page != null && page.length() > 0) ? page : "1";
		try {
			prepareData(product, request);
			productInfoSerivce.updateProductInfo(product);
			
			prodImg.setProductId(product.getId());
			String warningMsg = uploadFiles(prodImg, files);
			
			String[] deleteImageIds = request.getParameterValues("del");
			List<AProductImage> images = new LinkedList<>();
			if (deleteImageIds != null && deleteImageIds.length > 0) {
				for (String imageId : deleteImageIds) {
					try {
						int imgId = Integer.parseInt(imageId);
						images.add(productInfoSerivce.selectProductImage(imgId));
						productInfoSerivce.deleteProductImage(imgId);
					} catch (NumberFormatException e) {
						warningMsg += e.getMessage();
					}
				}
			}
			warningMsg += deleteFiles(images);
			if (warningMsg.length() > 0) {
				model.addAttribute("warning", 1);
				model.addAttribute("FileUploadError", warningMsg);
			}
			
			model.addAttribute("success", 1);
		} catch (Exception err) {
			model.addAttribute("success", 0);
			model.addAttribute("error", err.getMessage());
		}
		return "redirect:/rest/product/?pageNum=" + page + "&pageSize=10";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
		Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
		model.addAttribute("typeMap", map);
		String page = request.getParameter("page");
		page = (page != null && page.length() > 0) ? page : "1";
		
		try {
			String id = request.getParameter("prod_id");
			if (id != null && id.length() > 0) {
				int productId = Integer.parseInt(id);
				List<AProductImage> images = productInfoSerivce.selectProductImageByID(productId);
				int flag = productInfoSerivce.deleteProductInfo(productId);
				int del = productInfoSerivce.deleteProductImages(productId);
				String warningMsg = deleteFiles(images);
				if (flag * del > 0) {
					model.addAttribute("success", 1);
				}
				if (warningMsg.length() > 0) {
					model.addAttribute("warning", 1);
					model.addAttribute("img_del_err", warningMsg);
				}
			}
		} catch (Exception err) {
			model.addAttribute("success", 0);
			model.addAttribute("error", err.getMessage());
		}
		return "redirect:/rest/product/?pageNum=" + page + "&pageSize=10";
	}
	
	/**
	 * Reading data from HttpServletRequest object of product information form.
	 * @param product
	 * @param request
	 */
	private void prepareData(AProduct product, HttpServletRequest request) {
		String id = request.getParameter("prod_id");
		if (id != null && id.length() > 0) {
			product.setId(Integer.parseInt(id));
		}
		// common attributes
		product.setItemCode(request.getParameter("item_no"));
		Integer type = Integer.parseInt(request.getParameter("type"));
		product.setItemType(type);
		product.setPriceCost(Double.parseDouble(request.getParameter("price_cost")));
		product.setPriceAgent(Double.parseDouble(request.getParameter("price_agent")));
		product.setPriceRent(Double.parseDouble(request.getParameter("price_rent")));
		product.setPriceSell(Double.parseDouble(request.getParameter("price_sell")));
		product.setPriceAlliance(Double.parseDouble(request.getParameter("price_alliance")));
		String milian = request.getParameter("create_time");
		if (milian != null && milian.length() > 0) {
			Date createDate = new Date();
			createDate.setTime(Long.parseLong(milian));
			product.setCreateTime(createDate);
		} else {
			product.setCreateTime(new Date());
		}
		product.setUpdateTime(new Date());
		String createUid = request.getParameter("create_uid");
		if (createUid != null && createUid.length() > 0) {
			product.setCreateUid(Integer.parseInt(createUid));
		} else {
			product.setCreateUid(Integer.parseInt(request.getParameter("user_no")));
		}
		product.setUpdateUid(Integer.parseInt(request.getParameter("user_no")));
		
		// wedding
		if (type == 0 || type == 1) {
			String[] trends = request.getParameterValues("trends");
			if (trends.length > 0) {
				product.setTrends(String.join(",", trends));
			} else {
				product.setTrends("");
			}
			product.setSilhouette(request.getParameter("silhouette"));
			product.setNeckline(request.getParameter("waistline"));
			product.setWaistline(request.getParameter("waistline"));
			product.setSleeve(request.getParameter("sleeve"));
			product.setColor(request.getParameter("color"));
			product.setSize(request.getParameter("size"));
		}
		
		// shirt
		if (type == 2) {
			product.setCollarStays(Integer.parseInt(request.getParameter("collar")));
			product.setPlacket(Integer.parseInt(request.getParameter("placket")));
			product.setVersion(Integer.parseInt(request.getParameter("version")));
			product.setWhiteCollarSleeve(Integer.parseInt(request.getParameter("white_collar")));
			product.setPocket(request.getParameter("pocket"));
			product.setMaterial(request.getParameter("material"));
		}
		// suit
		if (type == 3) {
			
		}
		// return product;
	}

	/**
	 * Upload images of product.
	 * @param prodImg
	 * @param files
	 * @return Waring messages of that image uploading may be unsuccessful.
	 * @throws IOException
	 */
	private String uploadFiles(AProductImage prodImg, MultipartFile[] files) throws IOException{
		String fileName = null;
		Properties props = null;
		prodImg.setCreateDatetime(new Date());
		props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("/config.properties"));
		String uploadDir = props.getProperty("upload.dir");
		String baseURL = props.getProperty("upload.relative.baseurl");
		String warningMsg = "";
		if (files != null && files.length >0) {
    		for (int i = 0; i < files.length; i++) {
	            try {
	                fileName = files[i].getOriginalFilename();
	                int dotIndex = fileName.lastIndexOf('.');
	                if (dotIndex > 0 || files[i].getSize() > 0) {
	                	fileName = fileName.substring(dotIndex);
	                } else {
	                	warningMsg += files[i].getOriginalFilename() + ":" + "file name is invalid or file is empty. |";
	                	continue;
	                }
	            	fileName = "/product_img_" + Calendar.getInstance().getTimeInMillis() + fileName;
	            	String fileURL = baseURL + fileName;
	            	fileName = uploadDir + fileName;
	                byte[] bytes = files[i].getBytes();
	                BufferedOutputStream buffStream = 
	                        new BufferedOutputStream(new FileOutputStream(new File(fileName)));
	                buffStream.write(bytes);
	                buffStream.close();
	                // TODO: prodImg.setPriority(getParameter);
	                // TODO: prodImg.setImgSrc(fileURL);
	                // TODO: prodImg.setImgPath(filePath);
	                prodImg.setImgPath(fileURL);
	                productInfoSerivce.insertProductImage(prodImg);
	            } catch (Exception e) {
	            	warningMsg += files[i].getOriginalFilename() + ":" + e.getMessage() + "|";
	            }
    		}
        }
		return warningMsg;
	}
	
	/**
	 * Delete image files on disk.
	 * @param images
	 * @return Waring messages.
	 * @throws IOException
	 */
	private String deleteFiles(List<AProductImage> images) throws IOException{
		String warningMsg = "";
		Properties props = PropertiesLoaderUtils.loadProperties(new ClassPathResource("/config.properties"));
		String uploadDir = props.getProperty("upload.dir");
		for (AProductImage image : images) {
			String url = image.getImgPath();
			String fileName = "";
			int index = url.lastIndexOf('/');
			if (index > 0) {
	        	fileName = uploadDir + url.substring(index);
	        } else {
	        	fileName = uploadDir + url;
	        } 
			try {
				File fs = new File(fileName);
				if (fs.exists() && fs.isFile()) {
					if (fs.delete()) {
						System.out.println("Removed: " + fileName);
					}
				}
			} catch(Exception e) {
				warningMsg += fileName + ":" + e.getMessage();
			}
		}
		return warningMsg;
	}
	
}
