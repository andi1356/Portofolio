function PlaySound(soundobj) {
    var thissound=document.getElementById(soundobj);
    thissound.play();
	thissound.currentTime = 50;
}

function StopSound(soundobj) {
    var thissound=document.getElementById(soundobj);
    thissound.pause();
    hissound.currentTime = 50;
}
