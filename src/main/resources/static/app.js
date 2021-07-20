var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
        if (connected) {
            $("#conversation").show();
        }
        else {
            $("#conversation").hide();
        }
        $("#updates").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8080/ws');
    console.log("1");
    stompClient = Stomp.over(socket);
       console.log("2");
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        console.log("3");
        setConnected(true);
        stompClient.subscribe('/topic/updates', function (update) {
            //console.log(JSON.parse(update.body).content);
            showGreeting(JSON.stringify(update.body));
        });
    }, function (err) {
        console.log(err);
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showGreeting(message) {
    $("#updates").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });

});