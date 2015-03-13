function validar(e){
    tecla = (document.all) ? e.keyCode : e.which;
    if(tecla==8) return true;
    patron=/\d/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function sololetras (e){
    tecla = (document.all) ? e.keyCode : e.which;
    if(tecla==8) return true;
    patron=/\D/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}