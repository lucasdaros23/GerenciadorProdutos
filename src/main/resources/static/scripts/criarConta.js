async function criarConta() {
    const novaConta = {
        nome: document.getElementById("usernameTexto").value,
        senha: document.getElementById("passwordTexto").value
    };

    try {
        const response = await fetch(urlUsuarios, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(novaConta)
        });

        if (!response.ok) {
            alert("Não foi possível criar a conta. O usuário pode já existir.");
            throw new Error(`Erro na requisição: ${response.status}`);
        }

        const data = await response.json();
        console.log('Conta criada com sucesso:', data);
        alert("Conta criada com sucesso!");

        window.location.assign('../templates/index.html');

        return data;

    } catch (error) {
        console.error('Falha ao criar conta:', error);
    }
}