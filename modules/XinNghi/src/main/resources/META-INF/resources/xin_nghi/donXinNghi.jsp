<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<!DOCTYPE html>

<html>
  <head>
    <title>Đơn xin nghỉ phép</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet" />
  </head>
  <style>
    body {
      font-family: 'Tinos', serif ;
      color: black;
    }
  </style>
  <body>
  <button onclick="generatePDF()">Tạo File PDF</button>
    <div id="pdf-content">
      <div style="display: flex ; margin-top: 0px">
        <div style="border: none; width: 50%">
          <div class="oep-p-18" style="height: 100%; display: flex; justify-content: center; align-items: flex-start" align="center">
            <strong class="text-uppercase">
              TRUNG TÂM CÔNG NGHỆ THÔNG TIN & TRUYỀN THÔNG
              <br />
              Phòng Phần Mềm
              <br />
              --------------------------
            </strong>
          </div>
        </div>
    
      
    </div>
    <script>
      async function generatePDF() {
        const pdfOptions = {
          margin: 5,
          filename: 'donXinNghi.pdf',
          image: { type: 'jpeg', quality: 0.98 },
          html2canvas: { scale: 2 },
          jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' },
        };

        const content = document.getElementById('pdf-content').innerHTML;
         console.log("content "+ content)
      html2pdf()
         .set(pdfOptions)
         .from(content)
          .outputPdf('blob')
          .then((pdfData) => {
        	  console.log("pdfData "+ pdfData)
          const pdfBlob = new Blob([pdfData], { type: 'application/pdf' });
           console.log("pdfBlob "+ pdfBlob)
           const pdfUrl = URL.createObjectURL(pdfBlob);
           console.log("pdfUrl "+ pdfUrl)
            window.open(pdfUrl, '_blank');
          });

         
      }
      

    </script>
  </body>
</html>



