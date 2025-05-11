document.addEventListener('DOMContentLoaded', function () {
  // Delegasi event untuk tombol edit
  document.querySelectorAll('button[data-bs-target="#editModal"]').forEach(function (btn) {
      btn.addEventListener('click', function () {
          const url = btn.getAttribute('data-url');
          fetch(url)
              .then(response => response.json())
              .then(todo => {
                  document.getElementById('edit-id').value = todo.id;
                  document.getElementById('edit-task').value = todo.task;
                  document.getElementById('edit-date').value = todo.deadline;
              })
              .catch(err => {
                  alert('Gagal mengambil data todo!');
              });
      });
  });

  document.querySelectorAll('button[data-bs-target="#undoModal"]').forEach(function (btn) {
      btn.addEventListener('click', function () {
          const url = btn.getAttribute('data-url');
          fetch(url)
              .then(response => response.json())
              .then(todo => {
                  document.getElementById('undo-id').value = todo.id;
                  document.getElementById('undo-date').value = todo.deadline;
              })
              .catch(err => {
                  alert('Gagal mengambil data todo!');
              });
      });
  });
});
