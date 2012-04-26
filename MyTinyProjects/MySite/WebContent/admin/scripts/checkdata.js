function checkdata() {
    var title = document.form.title.value;
    var content = document.form.content.value;
    var length = title.length;
    var contLen = content.length;
    if (isSsnString(title)) {
        if ((5<=length) && (length<=60) && (contLen >=1)) {
            document.getElementById("errorTitle").innerHTML = "标题不少于5个字不多于20个字，可使用中文，英文字母，数字，下横线。内容至少一个字。";
            return true;
        }
    } 

    document.getElementById("errorTitle").innerHTML = "<font color='red'>标题不少于5个字不多于20个字，可使用中文，英文字母，数字，下横线。内容至少一个字。</font>";
    return false;
    
}

function isSsnString(ssn) {
    var re = /[\u4e00-\u9fa5\w]+/;
    if (re.test(ssn)) {
        return true;
    } else {
        return false;
    }

}
