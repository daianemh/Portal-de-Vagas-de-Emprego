document.addEventListener("DOMContentLoaded", function () {
    const empresaForm = document.getElementById("empresa-form");
    const candidatoForm = document.getElementById("candidato-form");
    const empresaLista = document.getElementById("empresa-lista");
    const candidatoLista = document.getElementById("candidato-lista");

    // Carregar empresas
    function carregarEmpresas() {
        fetch("http://localhost:8080/empresas")
            .then(response => response.json())
            .then(data => {
                empresaLista.innerHTML = "";
                data.forEach(empresa => {
                    const li = document.createElement("li");
                    li.textContent = `Nome: ${empresa.nome} | Email: ${empresa.email}`;
                    empresaLista.appendChild(li);
                });
            })
            .catch(error => console.error("Erro ao carregar empresas:", error));
    }

    // Carregar candidatos
    function carregarCandidatos() {
        fetch("http://localhost:8080/candidatos")
            .then(response => response.json())
            .then(data => {
                candidatoLista.innerHTML = "";
                data.forEach(candidato => {
                    const li = document.createElement("li");
                    li.textContent = `Nome: ${candidato.nome} | Email: ${candidato.email}`;
                    candidatoLista.appendChild(li);
                });
            })
            .catch(error => console.error("Erro ao carregar candidatos:", error));
    }

    // Adicionar nova empresa
    empresaForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const nome = document.getElementById("nome").value;
        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;
        const descricao = document.getElementById("descricao").value;

        const empresa = { nome, email, senha, descricao };

        fetch("http://localhost:8080/empresas", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(empresa)
        })
        .then(response => response.json())
        .then(() => {
            carregarEmpresas();
            empresaForm.reset();
        })
        .catch(error => console.error("Erro ao adicionar empresa:", error));
    });

    // Adicionar novo candidato
    candidatoForm.addEventListener("submit", function (e) {
        e.preventDefault();
        const nome = document.getElementById("nome").value;
        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;
        const curriculo = document.getElementById("curriculo").value;

        const candidato = { nome, email, senha, curriculo };

        fetch("http://localhost:8080/candidatos", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(candidato)
        })
        .then(response => response.json())
        .then(() => {
            carregarCandidatos();
            candidatoForm.reset();
        })
        .catch(error => console.error("Erro ao adicionar candidato:", error));
    });

    // Inicializar as listas
    carregarEmpresas();
    carregarCandidatos();
});
// Adicionar funcionalidade de exclusão
function excluirEmpresa(id) {
    fetch(`http://localhost:8080/empresas/${id}`, {
        method: "DELETE"
    })
    .then(() => carregarEmpresas())
    .catch(error => console.error("Erro ao excluir empresa:", error));
}

function excluirCandidato(id) {
    fetch(`http://localhost:8080/candidatos/${id}`, {
        method: "DELETE"
    })
    .then(() => carregarCandidatos())
    .catch(error => console.error("Erro ao excluir candidato:", error));
}

// Exibir botões de exclusão
function carregarEmpresas() {
    fetch("http://localhost:8080/empresas")
        .then(response => response.json())
        .then(data => {
            empresaLista.innerHTML = "";
            data.forEach(empresa => {
                const li = document.createElement("li");
                li.textContent = `Nome: ${empresa.nome} | Email: ${empresa.email}`;
                const excluirBtn = document.createElement("button");
                excluirBtn.textContent = "Excluir";
                excluirBtn.onclick = () => excluirEmpresa(empresa.id);
                li.appendChild(excluirBtn);
                empresaLista.appendChild(li);
            });
        })
        .catch(error => console.error("Erro ao carregar empresas:", error));
}

function carregarCandidatos() {
    fetch("http://localhost:8080/candidatos")
        .then(response => response.json())
        .then(data => {
            candidatoLista.innerHTML = "";
            data.forEach(candidato => {
                const li = document.createElement("li");
                li.textContent = `Nome: ${candidato.nome} | Email: ${candidato.email}`;
                const excluirBtn = document.createElement("button");
                excluirBtn.textContent = "Excluir";
                excluirBtn.onclick = () => excluirCandidato(candidato.id);
                li.appendChild(excluirBtn);
                candidatoLista.appendChild(li);
            });
        })
        .catch(error => console.error("Erro ao carregar candidatos:", error));
}
// Validação do formulário de empresa
empresaForm.addEventListener("submit", function (e) {
    e.preventDefault();
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
    const descricao = document.getElementById("descricao").value;

    if (!nome || !email || !senha) {
        alert("Por favor, preencha todos os campos obrigatórios.");
        return;
    }

    const empresa = { nome, email, senha, descricao };

    fetch("http://localhost:8080/empresas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(empresa)
    })
    .then(response => response.json())
    .then(() => {
        carregarEmpresas();
        empresaForm.reset();
    })
    .catch(error => console.error("Erro ao adicionar empresa:", error));
});
