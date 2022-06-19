### AJAX LOGIN

Q.강사님 AjaxLoginProcessingFilter를 만드신 이유가 AbstractAuthenticationProcessingFilter의
구현체에는usernamepasswordAuthenticationFilter가 있지만 ajax는 따로 없기 때문에 filter와 token을 만드신 건가요?

A.네 맞습니다

Ajax 방식으로 인증기능을 구현하기 위해서는 기존의 인증필터로는 구현이 어렵기 때문에 별도로 만들어서 사용해야 합니다

Rest 방식으로 http 통신하는 서비스에서 ajax 기술을 사용할 경우 해당된다고 보시면 될것 같습니다
<hr>
Q.form login을 진행하게 되면 서버의 session에 사용자가 저장이 되고 이것을 이용해서 권한까지 검사하는 것으로 알고있는데요,

그런데 ajax로 api/messages로 접근을 할 때 미리 로그인되었다는, 다시말해 클라이언트와 서버가 서로 jsessionId를 전송하지 않는 것처럼 보이는데 POST로 로그인 후 GET
api/messages를 할 때 서버는 이용자를 어떻게 구분하나요?

A.
ajax 로 통신을 할 때에도 request 객체의 header 에는 JSESSIONID 를 포함해서 서버로 전송됩니다.

브라우저가 하는 역할입니다.

보통 세션쿠키라고도 하는데요

최초 서버에서 발급한 세션쿠키를 Response 객체에 담아서 클라이언트로 보내게 되고 클라이언트가 서버로 요청할 때는 서버로 부터 받은 세션쿠기, 즉 JSESSIONID를 Request 객체에 담아서 보내는 과정이
Form 방식의 인증 혹은 Ajax 방식의 인증 모두 적용된다고 보시면 됩니다.

다만 요즘은 Ajax 방식의 Rest 통신을 할 때는 세션을 사용하지 않고 토큰 방식의 인증 및 권한을 사용해서 요청과 응답을 주고 받는 식으로 많이 구현을 합니다

JWT (Json Web Token) 으로 인증하는 방식입니다.

이 때는 아예 세션을 사용하지 않기 때문에 서버가 사용자가 누군지 알 수 없고 토큰에 포함 된 정보만을 해석해서 인증을 처리하게 됩니다.

참고하시면 됩니다.

<hr>
Q.Ajax방식에서 SavedRequest 가능여부
폼 로그인 방식에는 successHandler에 RequestCache를 통해 미인증 사용자가 접근했던 정보로 리다이렉트 했었는데

Ajax 통신에서는 success블럭에 window.location을 통해 이동하는 걸로 보여집니다. (초반엔 "/"였다가 19:07 에는 "/messages"로 변경되어있습니다.)

REST 환경이 아니라 해당 예시처럼 Ajax 통신 시 RequestCache 이용 가능한지 궁금합니다.

A.
네

RequestCache 는 인증 이전의 정보를 담고 있는 객체이고 이것을 세션에 담고 있다가 꺼내어 참조하는 방식입니다

Ajax 방식으로 통신하더라도 이 원리는 동일하게 적용할 수 있습니다

인증 성공 핸들러에서 RequestCache 에 담긴 리다이렉트 정보를 response 에 담아서 클라이언트로 전달하고 Ajax success 블럭에서 전달된 정보를 활용하면 될 것 같습니다

참고로 폼 인증과 Ajax 인증은 세션방식으로 인증을 진행할 경우 요청과 응답의 형태가 달라지지만 스프링 시큐리티에서 인증을 처리하는 원리와 흐름은 동일하다고 보시면 됩니다다

흔히 Rest 방식으로 세션없이 토큰으로만 인증을 진행할 경우 RequestCache 는 사용할 수 없습니다

왜냐하면 RequestCache 는 세션에 저장되기 때문입니다

감사합니다

<hr>