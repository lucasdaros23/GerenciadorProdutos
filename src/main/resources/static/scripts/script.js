document.addEventListener('DOMContentLoaded', function() {
    // Chama a função para listar os compromissos assim que a página estiver pronta.
    listarCompromissos();
});

function listarCompromissos() {
    const url = 'http://localhost:8080/compromisso';

    // Seleciona o container onde os itens do calendário serão exibidos.
    const containerCalendario = document.querySelector('.calendarioItens');

    // Limpa o conteúdo anterior para não duplicar itens se a função for chamada novamente.
    containerCalendario.innerHTML = '';

    fetch(url)
        .then(response => {
            // Verifica se a resposta da API foi bem-sucedida
            if (!response.ok) {
                throw new Error('Erro na rede: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
                console.log("Resposta completa da API:", data);

            // 'data' aqui deve ser um array de compromissos
            // Para cada compromisso no array, criamos um elemento no HTML.
const item = document.createElement('p');
    item.textContent = data.nome; // Use 'data' diretamente
    containerCalendario.appendChild(item);
        })
        .catch(error => {
            console.error('Erro ao buscar compromissos:', error);
            containerCalendario.textContent = 'Não foi possível carregar os compromissos.';
        });
}