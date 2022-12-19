package kr.or.ddit;

public class test {
	public static void main(String[] args) {
		 	String mail = "abced-naver.com";
	        
	        int idx = mail.indexOf("-"); 
	        
	        String mail1 = mail.substring(0, idx);
	        String mail2 = mail.substring(idx,idx+1);
	        String mail3 = mail.substring(idx+1);
	        String mail4=mail.substring(idx+1,idx+5);
	        System.out.println(mail4);
	}
}
