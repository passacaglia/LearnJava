$(function() {

	/* 判断浏览器 */
	if($.browser.msie) {
		$(':submit,:button,:reset').css({padding:'0px 5px'});
	}
	else {
		$(':radio,:checkbox').css({margin:'2px 5px'});
	};
	
	/* 去除Chrome中input的桔色边框 */
	$('input').focus(function(){
		$(this).css({outline:'none'});
	});
	
	/* 去掉链接点击时的虚线 */
	$('a').focus(function() {
		$(this).blur();
	});
	
	/* 表格样式 */
	$('#main table tr:gt(0):even').addClass('tr_even');
	$('#main table tr:gt(0):odd').addClass('tr_odd');
	$('#main table tr:gt(0)').hover(function() {
		$(this).addClass('on_tr');
	},function() {
		$(this).removeClass('on_tr');
	});
	
	/* 读取主题 */
	var themes = $.cookie('themes_cookie');
	if (themes != null) {
		var themesArray = new Array(
			'Default',
			'Google'
		);
		var is_themes = $.inArray(themes, themesArray);
		if(is_themes != '-1') {
			$('#themes').attr('href','themes/' + themes + '/common.css');

			$('#change_themes option').each(function() {
				var thisVal = $(this).val();
				if(thisVal == themes) $(this).attr('selected',true);
			})
		}
	}
	
	/* 更换主题 */
	$('#change_themes').change(function() {
		var optionVal = $(this).find('option:selected').val();
		$.cookie('themes_cookie', optionVal);
		window.parent.frames.location.reload();
	})
	
})

/* 加入收藏，兼容IE、Firefox、Opera，其它浏览器请按Ctrl+D */
function AddFavorite(url, title) {
	try {
		/* ie */
		window.external.addFavorite(url, title);
	} catch (e) {
		try {
			/* ff、opera */
			window.sidebar.addPanel(url, title, '');
		} catch (e) {
			alert('您的浏览器不支持自动添加，请手动添加！','提示信息');
		}
	}
}