function iconAppend(data, ok) {
	var str = '<li class="col-xs-3">'

	if (checkImg(data)) {
		str += '<img data-url="'+data+'" class="board_img_icon" alt="gt" src="/board/display?filename='+data+'">'
	} else {
		str += '<img data-url="'+data+'" class="board_img_icon" alt="gt" src="/resources/img/gt.png">'
	}
	str += '<div><span>' + getOriginalFileName(data) + '</span>'

	if (ok) {
		str += '<a href="'+data+'" class="btn btn-danger btn-xs delbtn">'
		str += '<span class="glyphicon glyphicon-remove"></span></a>'
	}
	str += '</div></li>'

	$('.uploadedList').append(str);
}

function checkImg(filename) {
	var type = filename.substring(filename.lastIndexOf(".") + 1);
	type = type.toLowerCase()
	if (type == 'png' || type == 'jpg' || type == 'jpeg' || type == 'gif') {
		return true;
	} else {
		return false;
	}
}

function getOriginalFileName(filename) {
	if (checkImg(filename)) {
		var idx = filename.indexOf('_', 14) + 1
	} else {
		var idx = filename.indexOf('_') + 1
	}
	return filename.substring(idx);
}

function getImgName(filename) {
	var prefix = filename.substring(0, 12);
	var suffix = filename.substring(14);
	return prefix + suffix;
}

