<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- 
Example of using jsp:setProperty and an explicity association
with an input parameter. See SaleEntry1.jsp
and SaleEntry3.jsp for alternatives. 
   
-->
<HTML>
<HEAD>
<TITLE>Using jsp:setProperty</TITLE>
</HEAD>

<BODY>

<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Using jsp:setProperty</TABLE>

<jsp:useBean id="entry" class="bean.SaleEntry" />

<jsp:setProperty 
    name="entry"
    property="itemID"
    value='<%=request.getParameter("itemID")%>' />
    
<jsp:setProperty 
    name="entry"
    property="numItems"
    param="numItems" />
    

<jsp:setProperty 
    name="entry"
    property="discountCode"
    param="discountCode" />

<BR>
<TABLE ALIGN="CENTER" BORDER=1>
<TR CLASS="COLORED">
  <TH>Item ID<TH>Unit Price<TH>Number Ordered<TH>Total Price
<TR ALIGN="RIGHT">
  <TD><jsp:getProperty name="entry" property="itemID" />
  <TD>$<jsp:getProperty name="entry" property="itemCost" />
  <TD><jsp:getProperty name="entry" property="numItems" />
  <TD>$<jsp:getProperty name="entry" property="totalCost" />
</TABLE>
             
</BODY>
</HTML>