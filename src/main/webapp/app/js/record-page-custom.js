$(function() {
    
    $('#btn-add-image').click(function(e) {
        e.preventDefault();
        var fileuploader = '<div class="col-xs-12 col-lg-3">';
        fileuploader += '  <div class="fileupload fileupload-new" data-provides="fileupload">';
        fileuploader += '    <div class="fileupload-preview thumbnail" data-trigger="fileupload" style="width: 200px; height: 150px;"></div>';
        fileuploader += '    <div>';
        fileuploader += '      <span class="btn btn-default btn-file">';
        fileuploader += '        <span class="fileupload-new">Select image</span>';
        fileuploader += '        <span class="fileupload-exists">Change</span>';
        fileuploader += '        <input type="file" name="file">';
        fileuploader += '      </span>';
        fileuploader += '      <a href="#" class="btn btn-default fileupload-exists" data-dismiss="fileupload">Remove</a>';
        fileuploader += '    </div>';
        fileuploader += '    <input type="hidden" name="imgId" value=""></input>';
        fileuploader += '  </div>';
        fileuploader += '</div>';
        fileuploader += '<div class="col-xs-12 col-sm-6 col-lg-6 form-horizontal">';
		fileuploader += '  <div class="form-group">';
		fileuploader += '	 <label for="imgTitle" class="col-sm-3 control-label">图片标题</label>';
		fileuploader += '    <div class="col-sm-8"><input class="form-control" id="imgTitle" name="imgTitle" value=""></div>';
		fileuploader += '  </div>';
		fileuploader += '  <div class="form-group">';
		fileuploader += '    <label for="imgPrior" class="col-sm-3 control-label">图片优先级</label>';
		fileuploader += '    <div class="col-sm-8"><input class="form-control" id="imgPrior" name="imgPrior" value=""></div>';
		fileuploader += '  </div>';
		fileuploader += '  <div class="form-group">';
		fileuploader += '    <label for="imgDesc" class="col-sm-3 control-label">图片描述</label>';
		fileuploader += '    <div class="col-sm-8"><textarea class="form-control" id="imgDesc" name="imgDesc" value="" rows="3"></textarea></div>';
		fileuploader += '  </div>';
		fileuploader += '</div>';
		fileuploader += '<div class="clearfix"></div>';
        
        $(fileuploader).insertBefore(this.parentNode);
    });
        
});