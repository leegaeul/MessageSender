# MessageSender
API Store의 대용량 SMS 서비스 활용 API

Receipt receipt = Messanger
    .message("message", "subject")
    .from("sender_number", "sender_name")
    .to("receiver_number", "receiver_name")
    .when("2017-02-16 18:03:00")
    .send();
