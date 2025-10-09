const urlCompromissos = 'http://localhost:8080/compromisso';

async function listarCompromissos() {
    try {
        const response = await fetch(urlCompromissos);
        if (!response.ok) {
            throw new Error('Erro na rede: ' + response.statusText);
        }
        const baseResponse = await response.json();
        if (baseResponse && Array.isArray(baseResponse.data)) {
            return baseResponse.data;
        } else {
            return [];
        }
    } catch (error) {
        console.error('Erro ao buscar compromissos:', error);
        return [];
    }
}


function popularCalendario(compromissos) {
    const container = document.querySelector('.calendarioItens');

    const compromissosDoCalendario = compromissos.filter(c => c.tipo === 'CALENDARIO');

    document.getElementById("containerCalendarioTexto").innerHTML = ''
    container.innerHTML = ''

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

    const itensDaWishlist = compromissos.filter(c => c.tipo === 'WISHLIST');

    document.getElementById("containerWishlistTexto").innerHTML = ''
    container.innerHTML = ''

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