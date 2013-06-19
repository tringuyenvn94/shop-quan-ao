/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function dangKyClick(){
	//$('.overlay').fadeTo(500, 0.8);
	var mk = document.getElementById("txtMatKhau");
        var mk2 = document.getElementById("txtMatKhau2");
        if(mk.value != mk2.value){
            alert("Nhập lại mật khẩu không đúng!");
        }else{
            document.frmDangKy.submit();
            return false;
        }
}


