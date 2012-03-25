
function checkdata() {
	var ssn = form.username.value.toLowerCase();
	
	if (!checkUserName(ssn)) {//check user name
		return false;
	}
	
	if (!form.gender[0].checked && !form.gender[1].checked) {
		//alert("请选择性别");
		document.getElementById("sexErr").innerHTML = "<font color='red'>请选择性别</font>";
		form.sex[0].focus();
		return false;
	}
	
	
	
	
	
	if (form.theplace.selectedIndex == 0) {
		//alert("Where are you from baby?");
		document.getElementById("placeErr").innerHTML = "<font color='red'>Where are you from baby?</font>";
		form.place.focus();
		return false;
	}
	
	if (form.intro.value == "") {
		//alert("Introduce yourselft please.");
		document.getElementById("introErr").innerHTML = "<font color='red'>Please introduce yourself.</font>";
		form.intro.focus();
		return false;
	}
	
	return true;
	
}


function checkUserName(ssn) {
	if ( ssn.length<3 || ssn.length>18 ) {
		//alert("Please input the right user name, the lenght should be between 3 and 18.");
		document.getElementById("unErr").innerHTML = "<font color='red'> Please input the right username, legth between 3 and 18.</font>";
		form.username.focus();
		return false;
	}
	
	if (isWhiteWpace(ssn)) {
		//alert("No space in user name, sorry.");
		document.getElementById("unErr").innerHTML = "<font color='red'>Space are not allowed in the user name, please select all and then input again.</font>";
		form.username.focus();
		return false;
	}
	
	if (!isSsnString(ssn)) {
		//alert(" Sorry, the user name you input has been used.");
		document.getElementById("unErr").innerHTML = "<font color='red'>Sorry, the user name you input has been used.</font>";
		form.username.focus();
		return false;
	}
	
	document.getElementById("unErr").innerHTML = "";
	return true;
}


function isWhiteWpace(s) {
	var whitespace = " \t\n\r";
	var i;
	for (i=0; i<s.length; i++) {
		var c = s.charAt(i);
		if (whitespace.indexOf(c) >=0) {
			return true;
		}
	}
	return false;
}


function isSsnString(ssn) {
	var re = /^[0-9a-z][\w-.]*[0-9a-z]$/i;
	if (re.test(ssn)) {
		return true;
	} else {
		return false;
	}
	
}



function checkPwd() {
	if (strlen(form.pwd.value)<6 || strlen(form.pwd.value)>16) {
		//alert("The length of the password should be between 6 and 16. And English letters, numbers, only");
		document.getElementById("pwdErr").innerHTML = "<font color='red'>The length of the password should be between 6 and 16. And English letters, numbers, only.</font>";
		form.pwd.focus();
		return false;
	}
	
	if (unknownChar(form.pwd.value)) {
		//alert("English letters , numbers, only!!");
		document.getElementById("pwdErr").innerHTML = "<font color='red'>The length of the password should be between 6 and 16. And English letters, numbers, only.</font>";
		form.pwd.focus();
		return false;
	}
	
	if (form.pwd.value == form.username.value) {
		//alert("Your password is same as your username , that's not a good idea.");
		document.getElementById("pwdErr").innerHTML = "<font color='red'>Your password is same as your username , that's not a good idea.</font>";
		form.pwd.focus();
		return false;
	}
	
	document.getElementById("pwdErr").innerHTML = "";
	
}





function checkCfPwd() {
	if ("" == form.pwdconfirm.value) {
		//alert("Please confirm your password.");
		document.getElementById("pwdCfErr").innerHTML = "<font color='red'>Please confirm your password.</font>";
		form.pwdconfirm.focus();
		return false;
	}
	
	if (form.pwd.value != form.pwdconfirm.value) {
		//alert("两次密码不一致");
		document.getElementById("pwdCfErr").innerHTML = "<font color='red'>两次密码不一致</font>";
		form.pwd.focus();
		return false;
	}
	
	document.getElementById("pwdCfErr").innerHTML = "";
	
}








function strlen(str) {
	var len;
	var i;
	len = 0;
	for (i=0; i<str.length; i++) {
		if (str.charCodeAt(i)>255) {
			len+=2;//>255就不是Ascii码了。（每个字占2个字节）
		} else {
			len++;
		}
	}
	
	return len;
		 
}

function unknownChar(str) {
	var len;
	var i;
	len = 0;
	for (i=0; i<str.length; i++) {
		if (str.charCodeAt(i)>255) {
			alert("含有非法字符");
			return true;
		}
	}
	return false;
}


function setSex() {
	document.getElementById("sexErr").innerHTML = "";
}

function setPlace() {
	document.getElementById("placeErr").innerHTML = "";
}

function setIntro() {
	document.getElementById("introErr").innerHTML = "";
}














