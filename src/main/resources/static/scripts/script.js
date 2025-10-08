const urlCompromissos = 'http://localhost:8080/compromisso';

function listarCompromissos() {
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

            } else {
                console.error("A resposta da API não contém um array 'data'.", baseResponse);
                document.querySelector('.calendarioItens').textContent = 'Formato de dados inválido.';
                document.querySelector('.wishlistItens').textContent = 'Formato de dados inválido.';
            }
        })
        .catch(error => {
            console.error('Erro ao buscar compromissos:', error);
            document.querySelector('.calendarioItens').textContent = 'Falha ao carregar dados.';
            document.querySelector('.wishlistItens').textContent = 'Falha ao carregar dados.';
        });

        
}


function popularCalendario(compromissos) {
    const container = document.querySelector('.calendarioItens');
    container.innerHTML = ''; // Limpa o container

    const compromissosDoCalendario = compromissos.filter(c => c.tipo === 'CALENDARIO');

    if (compromissosDoCalendario.length > 0) {
        compromissosDoCalendario.forEach(compromisso => {
            const item = document.createElement('p');
            item.textContent = compromisso.nome;
            container.appendChild(item);
        });
    } else {
        container.textContent = 'Nenhum compromisso agendado.';
    }
}

function popularWishlist(compromissos) {
    const container = document.querySelector('.wishlistItens');
    container.innerHTML = '';

    const itensDaWishlist = compromissos.filter(c => c.tipo === 'WISHLIST');

    if (itensDaWishlist.length > 0) {
        itensDaWishlist.forEach(itemDesejado => {
            const item = document.createElement('p');
            item.textContent = itemDesejado.nome;
            container.appendChild(item);
        });
    } else {
        container.textContent = 'Nenhum item na sua wishlist.';
    }
}