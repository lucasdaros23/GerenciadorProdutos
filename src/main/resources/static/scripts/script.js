function listar(){
    let url = 'http://localhost:8080/compromisso';

    fetch(url)
        .then(res => res.json())
        .then(data => {saida.textContent = JSON.stringify(data, null, 2);})
        .catch(err => {console.error(err);saida.textContent = "Erro: " + err.message;});
}

function listarCompromissos(){

    let [listaComp] = await listar()
    return
}

function adicionar(){
let obj ={
    nome: nom
}
            fetch(url, {
                headers: headers,
                method: "POST",
                body: JSON.stringify(colaborador)
                })
                .then(res => res.json())
                .then(data => {saida.textContent = JSON.stringify(data, null, 2);})
                .catch(err => {console.error(err);saida.textContent = "Erro: " + err.message;});
        };
}