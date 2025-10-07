// script.js - VERSÃO FINAL COM CALENDÁRIO E WISHLIST

document.addEventListener('DOMContentLoaded', function() {
    // Apenas uma chamada para buscar todos os dados.
    listarCompromissos();
});

/**
 * Função principal que busca TODOS os compromissos da API.
 */
function listarCompromissos() {
    const url = 'http://localhost:8080/compromisso';

    fetch(url )
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na rede: ' + response.statusText);
            }
            return response.json();
        })
        .then(baseResponse => {
            console.log("Dados recebidos da API:", baseResponse);

            // Verifica se a resposta da API tem a estrutura esperada
            if (baseResponse && Array.isArray(baseResponse.data)) {
                const todosCompromissos = baseResponse.data;

                // Chama as funções específicas para popular cada card
                popularCalendario(todosCompromissos);
                popularWishlist(todosCompromissos);
            } else {
                console.error("A resposta da API não contém um array 'data'.", baseResponse);
                document.querySelector('.calendarioItens').textContent = 'Formato de dados inválido.';
                document.querySelector('.wishlistItens').textContent = 'Formato de dados inválido.';
            }
        })
        .catch(error => {
            console.error('Erro ao buscar compromissos:', error);
            // Exibe a mensagem de erro em ambos os containers
            document.querySelector('.calendarioItens').textContent = 'Falha ao carregar dados.';
            document.querySelector('.wishlistItens').textContent = 'Falha ao carregar dados.';
        });
}

/**
 * Filtra e exibe os compromissos do tipo CALENDARIO.
 * @param {Array} compromissos - A lista completa de compromissos.
 */
function popularCalendario(compromissos) {
    const container = document.querySelector('.calendarioItens');
    container.innerHTML = ''; // Limpa o container

    const compromissosDoCalendario = compromissos.filter(c => c.tipoPai === 'CALENDARIO');

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

/**
 * Filtra e exibe os compromissos do tipo WISHLIST.
 * @param {Array} compromissos - A lista completa de compromissos.
 */
function popularWishlist(compromissos) {
    const container = document.querySelector('.wishlistItens');
    container.innerHTML = ''; // Limpa o container

    const itensDaWishlist = compromissos.filter(c => c.tipoPai === 'WISHLIST');

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
