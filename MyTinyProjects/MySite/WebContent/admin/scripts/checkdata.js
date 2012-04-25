function checkdata() {
    var title = document.form.title.value;
    alert(title);
    if (isSsnString(title)) {
        return true;
    } 

    document.getElementById("errorTitle").innerHTML = "<font color='red'>标题不少于5个字不多于20个字，可使用中英文，数字，下横线</font>";
    return false;
    
}

function isSsnString(ssn) {
    var re = /[\u4e00-\u9fa5\w]+/;
    if (re.test(ssn)) {
        alert("Yes,  isSsnString");
        return true;
    } else {
        alert("Not  isSsnString");        
        return false;
    }

}


function strlen(str) {
    
   var sStr,iCount,i,strTemp ;

   iCount = 0 ;
   sStr = sString.split("");
    for (i = 0 ; i < sStr.length ; i ++)
     {
         strTemp = escape(sStr[i]);
          if (strTemp.indexOf("%u",0) == -1)
          {
              iCount = iCount + 1 ;
          }
          else
          {
              iCount = iCount + 2 ;
          }
      }
    
    alert(iCount);
    return iCount;
 
    

}