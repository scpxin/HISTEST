export function formatDate(date, format) {
  format = format || 'YYYY-MM-DD';
  if (!date) return '';
  var d = new Date(date);
  var year = d.getFullYear();
  var month = String(d.getMonth() + 1).padStart(2, '0');
  var day = String(d.getDate()).padStart(2, '0');
  return format.replace('YYYY', String(year)).replace('MM', month).replace('DD', day);
}

export function formatDateTime(date) {
  if (!date) return '';
  var d = new Date(date);
  return formatDate(d) + ' ' + String(d.getHours()).padStart(2, '0') + ':' + String(d.getMinutes()).padStart(2, '0');
}

export function debounce(fn, delay) {
  delay = delay || 300;
  var timer;
  return function () {
    var args = arguments;
    var self = this;
    clearTimeout(timer);
    timer = setTimeout(function () { fn.apply(self, args); }, delay);
  };
}
