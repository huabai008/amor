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
        fileuploader += '  </div>';
        fileuploader += '</div>';
        
        $(fileuploader).insertBefore(this.parentNode);
    });
        
});