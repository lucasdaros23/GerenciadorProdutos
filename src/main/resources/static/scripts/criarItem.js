function criarItemWishlist(){
    div = getElementById("item-list");
    div.textContent = ''

    fetch(urlCompromissos )
            .then(response => {
            if (!response.ok) {
                throw new Error('Erro na rede: ' + response.statusText);
            }
            return response.json();
        })
        .then(baseResponse => {
            console.log("Dados recebidos da API:", baseResponse);

            if (baseResponse && Array.isArray(baseResponse.data)) {
                const todosCompromissos = baseResponse.data;
            }
        })
        .catch(error => {
            console.error('Erro ao buscar compromissos:', error);
            document.querySelector('.calendarioItens').textContent = 'Falha ao carregar dados.';
            document.querySelector('.wishlistItens').textContent = 'Falha ao carregar dados.';
        });
        return todosCompromissos;   
}

