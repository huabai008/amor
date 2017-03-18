package com.amor.web.solr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.core.util.Constants;
import com.amor.orm.mapper.ABusinessDictMapper;
import com.amor.orm.model.AProduct;
import com.amor.orm.model.AProductForSolr;
import com.amor.orm.model.AProductImage;
import com.amor.orm.model.PageForSolr;
import com.amor.service.ProductInfoService;

@Service
public class SolrProductServiceImpl implements SolrProductService {

	@Resource
	private ProductInfoService productService;

	@Resource
	private ABusinessDictMapper dictMapper;

	@Resource
	private SolrBaseService solrService;

	@Override
	public void insert(AProduct product) {
		if (!solrService.hasCore())
			solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);

		solrService.addBean(transProduct4Solr(product));
	}

	/**
	 * 转换 提取solr需要的字段内容
	 * 
	 * @param product
	 * @return
	 */
	private AProductForSolr transProduct4Solr(AProduct product) {
		if (product == null)
			return null;
		AProductForSolr result = new AProductForSolr();
		result.setId(product.getId());
		result.setItemCode(product.getItemCode());
		if (product.getItemType() != null)
			result.setItemType(dictMapper.selectValueByDictAndKey("product_type", product.getItemType()));
		if (product.getTrends() != null) {
			String trends = "";
			for (String trend : product.getTrends().split(",")) {
				if (trends != "")
					trends += ",";
				trends += dictMapper.selectValueByDictAndKey("product_trends", Integer.parseInt(trend.trim()));
			}
			result.setTrends(trends);
		}
		if (product.getSilhouette() != null)
			result.setSilhouette(dictMapper.selectValueByDictAndKey("product_silhouette", product.getSilhouette()));
		if (product.getNeckline() != null)
			result.setNeckline(dictMapper.selectValueByDictAndKey("product_neckline", product.getNeckline()));
		if (product.getWaistline() != null)
			result.setWaistline(dictMapper.selectValueByDictAndKey("product_waistline", product.getWaistline()));
		if (product.getSleeve() != null)
			result.setSleeve(dictMapper.selectValueByDictAndKey("product_sleeve", product.getSleeve()));
		if (product.getVersion() != null)
			result.setVersion(dictMapper.selectValueByDictAndKey("product_version", product.getVersion()));
		if (product.getColor() != null)
			result.setColor(dictMapper.selectValueByDictAndKey("product_color", product.getColor()));
		if (product.getSize() != null)
			result.setSize(dictMapper.selectValueByDictAndKey("product_size", product.getSize()));
		result.setAll(result.getAll());
		return result;
	}

	@Override
	public void delete(Integer id) {
		if (!solrService.hasCore())
			solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		solrService.deleteById(String.valueOf(id));
	}

	@Override
	public List<AProduct> query(String query) {
		if (!solrService.hasCore())
			solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		List<AProduct> result = solrService.query(query, AProduct.class);
		for (int i = 0; i < result.size(); i++) {
			result.set(i, productService.selectProductByID(result.get(i).getId()));
		}
		return result;
	}

	@Override
	public PageForSolr<AProduct> getPage(PageForSolr<AProduct> page) {
		if (!solrService.hasCore())
			solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		solrService.getPage(page, AProduct.class);

		String imgOc = "assets/img/no-image.jpg";
		for (int i = 0; i < page.getList().size(); i++) {
			Integer id = page.getList().get(i).getId();
			page.getList().set(i, productService.selectProductByID(id));

			AProductImage image = productService.selectTopPriorityImage(id);

			page.setModelImage(id, image == null ? imgOc : image.getImgPath());
		}
		return page;
	}

	public void optimize() {
		if (!solrService.hasCore())
			solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		solrService.optimize();
	}
}
