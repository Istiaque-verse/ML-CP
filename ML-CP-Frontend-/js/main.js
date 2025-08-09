document.addEventListener("DOMContentLoaded", () => {
  const API_URL = "http://localhost:8080";

  async function fetchProblems() {
    const difficulty = document.getElementById("difficultySelect")?.value;
    const logic = document.getElementById("logicSelect")?.value;

    try {
      const res = await fetch(`${API_URL}/problems`);
      const data = await res.json();

      console.log("Fetched problems:", data);

      const filtered = data.filter(p => {
        // Adjust filtering later if you add difficulty in backend
        const difficultyMatch = !difficulty || p.difficulty == difficulty;
        return difficultyMatch;
      });

      displayProblemList(filtered);
    } catch (err) {
      console.error("Error fetching problems:", err);
    }
  }

  function displayProblemList(problems) {
    const problemList = document.getElementById("problemList");
    problemList.innerHTML = problems.length
      ? problems.map(p => {
          const topics = (p.topics || []).join(', ');
          return `
            <div class="card mb-2 shadow-sm">
              <div class="card-body">
                <a href="${p.link || '#'}" target="_blank">${p.title}</a>
                <p class="mb-0">
                  <strong>Tags:</strong> ${topics || 'None'} 
                  ${p.difficulty ? `| <strong>Difficulty:</strong> ${p.difficulty}` : ''}
                </p>
                <p>${p.description || ''}</p>
              </div>
            </div>
          `;
        }).join("")
      : '<div class="alert alert-info">No problems found.</div>';
  }

  window.fetchProblems = fetchProblems;
});
