function checkImg(filename) {

	/* 	var pattern = /jpg|jpeg|png|gif/i;
	return filename.match(pattern); */

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
	/* return filename.replace('s_', ''); */
	/* var filename = filename.split("s_") 
	return filename[0]+filename[1]; */
	var prefix = filename.substring(0, 12);
	var suffix = filename.substring(14);
	return prefix + suffix;
}

function iconAppend(data, ok) {
	var str = '<li class="col-xs-3">'

	if (checkImg(data)) {
	    /*str += '<a target="_blank" href="display?filename='+getImgName(data)+'">'*/
		str += '<img data-url="'+data+'" class="board_img_icon" alt="gt" src="/display?filename='+data+'">'
		/*str += '</a>'*/
	} else {
		/*str += '<a href="display?filename='+data+'">'*/
		str += '<img data-url="'+data+'" class="board_img_icon" alt="gt" src="/resources/img/gt.png">'
		/*str += '</a>'*//*just for read*/
	}
	str += '<div><span>' + getOriginalFileName(data) + '</span>'

	if (ok) {
		str += '<a href="'+data+'" class="btn btn-danger btn-xs delbtn">'
		str += '<span class="glyphicon glyphicon-remove"></span></a>'
	}
	str += '</div></li>'

	$('.uploadedList').append(str);
}