document.addEventListener('DOMContentLoaded', () => {
  const rows = document.querySelectorAll('.posts-table tbody tr');

  rows.forEach((row, i) => {
    row.style.animationDelay = `${i * 0.05}s`;
    row.style.animation = 'fadeUp .4s ease both';
  });

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.style.opacity = '1';
        entry.target.style.transform = 'translateY(0)';
      }
    });
  }, { threshold: 0.1 });

  document.querySelectorAll('.feature-card').forEach(card => {
    card.style.opacity = '0';
    card.style.transform = 'translateY(24px)';
    card.style.transition = `opacity .5s ease ${card.style.getPropertyValue('--delay') || '0s'}, transform .5s ease ${card.style.getPropertyValue('--delay') || '0s'}`;
    observer.observe(card);
  });

  document.querySelectorAll('.tr--clickable').forEach(row => {
    row.addEventListener('click', () => {
      window.location.href = row.dataset.href;
    });
  });
});
