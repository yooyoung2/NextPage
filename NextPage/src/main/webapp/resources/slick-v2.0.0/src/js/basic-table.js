/*-----------------------------------------------
|   Basictable
-----------------------------------------------*/
/*eslint-disable*/

const tableCollationInit = () => {
  const tableCollations = document.querySelectorAll("[data-table-collation]");

  tableCollations.forEach((table) => {
    const rows = table.querySelectorAll("thead > tr, tbody > tr, tfoot > tr");
    const numCols = table.querySelectorAll("thead > tr > th").length;
    let col_i = 1;
    while (col_i < numCols) {
      const stackTable = document.createElement("table");
      stackTable.classList.add("table", "stacktable", "d-lg-none");
      table.classList.add("stacktable", "d-none", "d-lg-table");

      const th = document.createElement("thead");
      const tb = document.createElement("tbody");

      const lastIndex = rows.length - 1;

      rows.forEach((row, index) => {
        const tr = document.createElement("tr");
        const first = row.querySelector("td,th").cloneNode(true);
        first.classList.add("st-key");
        const target = col_i;
        const second = row.querySelectorAll("td,th")[target].cloneNode(true);

        second.classList.add("st-val");
        second.removeAttribute("colspan");

        if (index === 0) {
          second.setAttribute("colspan", 2);
          tr.append(second);
          th.append(tr);
        } else if (index === lastIndex) {
          second.setAttribute("colspan", 2);
          tr.append(second);
          tb.append(tr);
        } else {
          tr.append(first, second);
          tb.append(tr);
        }
      });
      stackTable.append(th);
      stackTable.append(tb);
      table.parentNode.insertBefore(stackTable, table);
      col_i++;
    }
  });
};
export default tableCollationInit;
