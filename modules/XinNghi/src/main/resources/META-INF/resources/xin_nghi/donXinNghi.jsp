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
        <div style="border: none; width: 50%">
          <div class="oep-p-18" style="height: 100%; display: flex; justify-content: center; align-items: flex-start" align="center">
            <strong class="text-uppercase">
              CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
              <br />
              Độc lập - Tự do - Hạnh phúc
              <br />
              --------------------------
            </strong>
          </div>
        </div>
      </div>
      <table style="width: 100%; border: none">
        <tbody>
          <tr>
            <td width="50%" style="border: none"></td>
            <td width="50%" style="border: none" class="float-right">
              <div style="display: flex  ; margin-left: 5px; justify-content: center">
                <i style="margin-left: -210px"> Bắc Ninh, ngày 31 tháng 3 năm 2023 </i>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
      <br />
      <div class="form-group row font-weight-bold" align="center">
        <strong for="" class="col-sm-12 col-form-label font-weight-bold"> ĐƠN XIN NGHỈ PHÉP </strong>
      </div>
      <br />
      <div class="form-group row">
        <div for="" class="" style="padding-left: 30px; margin-bottom: 0px">Kính gửi: Lãnh đạo Trung tâm Công nghệ thông tin và Truyền thông</div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px; margin-bottom: 0px" for="" class="">Tên tôi là: Vũ Văn Hạnh</div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px; margin-bottom: 0px" for="" class="">Chức vụ: Viên chức</div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px; margin-bottom: 0px" for="" class="">Đơn vị công tác: Phòng Phần Mềm</div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px ;  margin-bottom: 0px" for="" class="col-sm-12 col-form-label">
          Tôi có việc cá nhân cần giải quyết nên tôi xin phép nghỉ thứ 6 ngày 31/3 nên tôi xin phép Lãnh đạo Trung tâm Công nghệ thông tin và Truyền
          thông cho phép tôi được nghỉ phép 1 ngày từ 2023-03-31 đến 2023-03-31. Tôi có việc cá nhân cần giải quyết nên tôi xin phép nghỉ thứ 6 ngày 31/3 nên tôi xin phép Lãnh đạo Trung tâm Công nghệ thông tin và Truyền
          thông cho phép tôi được nghỉ phép 1 ngày từ 2023-03-31 đến 2023-03-31.
        </div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px; margin-bottom: 0px" for="" class="">Rất mong được sự quan tâm và phê duyệt của Lãnh đạo Trung tâm.</div>
      </div>
      <div class="form-group row">
        <div style="padding-left: 30px" for="" class="">Tôi xin chân thành cảm ơn./.</div>
      </div>
      <br />
      <table style="width: 100%; border: none">
        <tbody>
          <tr>
            <td width="33%" style="border: none">
              <p class="oep-p-18" style="padding-top: 0 !important" align="center">
                <strong class="text-uppercase">LÃNH ĐẠO TRUNG TÂM</strong><br /><br /><br /><br /><br /><br />
                <strong>Nguyễn Ngọc Nam </strong>
              </p>
            </td>

            <td width="33%" style="border: none">
              <p class="oep-p-18" style="padding-top: 0 !important" align="center">
                <strong class="text-uppercase">LÃNH ĐẠO PHÒNG</strong><br /><br /><br /><br /><br /><br />
                <strong>Phạm Anh Minh </strong>
              </p>
            </td>

            <td width="33%" style="border: none">
              <p class="oep-p-18" style="padding-top: 0 !important" align="center">
                <strong class="text-uppercase">NGƯỜI LÀM ĐƠN</strong><br /><br /><br />
                <strong>Đã ký</strong>
                <br /><br /><br /><strong>Vũ Văn Hạnh</strong>
              </p>
            </td>
          </tr>
        </tbody>
      </table>
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


<button onclick="generatePDF()">Tạo File PDF</button>
