2020/06/24<br>
Spring annotation 게시판<br>
[model]<br>
String 값을 저장할 필요없는 방식으로 진행되고있다<br>

[Sp10_springMVC_login예제로 정리]<br>

Index.xml 파일을 만드는 이유.<br>
JSP파일로 들어가 실행시 url을 변경해서 들어가야하나 index.html파일을 만들어<br>
회원가입, 로그인, 회원 확인등으로 들어갈수있는 각자의 경로(href)를 만든다<br>
⌜ 경로 만들기 : <a href = “ join.bo”>회원가입</a> ⌟<br>


joinForm.jsp 파일<br>
작동할 명령을 작성하여 입력한다.<br>
Form action에는 입력후 이동할 파일위치를 작성, method에는 입력방식(get, post)을 넣는다.<br>
- Get방식은 url에 입력하는 데이터가 출력되어 노출이된다.<br>
- Post방식은 body의 전송되는 방식으로 get보다는 보안이 좋다.<br>
⌜<form action=”join.bo” method=”post”><br>
<input type=”text” name=”name” size=”20” placeholder=”name input”>⌟<br>

joinController.java 파일<br>
RequestMapping은 다른 파일과 연결할수있는 경로를 만들어주는것이다.<br>
현 예제에서는 RequestMapping(“/join.bo”)라는 경로를 주어 index.html에서 join.bo(회원가입)를 클릭시 joinController.java에서 GET방식을 실행한후 joinForm.jsp로 이동한다.<br>
joinForm.jsp로 이동후 개인정보 입력값을 전송받아 POST방식으로 실행되어 public String submit를 실행되어진다 <br>
★ JoinForm.jsp에서 이동한 개인정보는 POST방식으로 전송되었기 때문에 POST 방식으로 실행되어진다.<br>
회원가입 처리시 중복확인을 하는것도 적용되어 졌기때문에 if문 안에서 중복시 joinForm.jsp으로 다시 실행되어지고 중복되는것이 없을시 joinSuccess.jsp으로 넘어간다.






