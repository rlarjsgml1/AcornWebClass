<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>숙박 기간 선택</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
    <script>
    
     //https://code.jquery.com/ui   => datepicker 제공함
     /*
     
         $(document).ready( function(){});       // 문서로드완료후 실행코드 , DOM
         $(function(){}); 
         
         $(window).on("load", function () {
        	    // 모든리소스 포함 전체 로드 완료 후 실행
         });
     */
     
     
        $(function () {
            // 종료일 input은 readonly
            $("#to").prop("readonly", true);

            // 시작일 Datepicker
            $("#from").datepicker({
                dateFormat: "yy-mm-dd",
                minDate: new Date(),
                onSelect: function(selectedDate) {
                    updateEndDateLimit();
                }
            });

            // 종료일 Datepicker
            $("#to").datepicker({
                dateFormat: "yy-mm-dd",
                onSelect: function() {
                    calculateNights();
                }
            });

            // 숙박일수 선택 시 종료일 제한 적용
            $("#nights").change(function() {
                const nights = parseInt($(this).val());
                if (!nights) return;

                const start = $("#from").datepicker("getDate");
                if (start) {
                    // 종료일 최대값 = 시작일 + 숙박일수
                    const maxEnd = new Date(start);
                    maxEnd.setDate(start.getDate() + nights);
                    $("#to").datepicker("option", "maxDate", maxEnd);
                    // 종료일 자동 설정
                    $("#to").datepicker("setDate", maxEnd);
                }
            });

            function updateEndDateLimit() {
                const start = $("#from").datepicker("getDate");
                const nights = parseInt($("#nights").val());

                if (start && nights) {
                    const maxEnd = new Date(start);
                    maxEnd.setDate(start.getDate() + nights);
                    $("#to").datepicker("option", "minDate", start);
                    $("#to").datepicker("option", "maxDate", maxEnd);
                    // 자동으로 종료일 갱신
                    $("#to").datepicker("setDate", maxEnd);
                }
            }

            function calculateNights() {
                const start = $("#from").datepicker("getDate");
                const end = $("#to").datepicker("getDate");
                if (start && end) {
                    const diffTime = end - start;
                    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
                    $("#nights").val(diffDays);
                }
            }
        });
    </script>
</head>
<body>
<h2> 숙박 기간 선택 (숙박일수 기준)</h2>

<form action="date" method="post">
    <label>숙박일수:</label>
    <select id="nights" name="nights">
        <option value="">선택</option>
        <option value="2">2박 3일</option>
        <option value="3">3박 4일</option>
        <option value="4">4박 5일</option>
    </select>
    <br><br>

    <label>시작일:</label>
    <input type="text" id="from" name="startDate" readonly placeholder="시작일 선택">
    <br><br>

    <label>종료일:</label>
    <input type="text" id="to" name="endDate" readonly placeholder="종료일 자동 제한">
    <br><br>

    <button type="submit">보내기</button>
</form>

</body>
</html>
