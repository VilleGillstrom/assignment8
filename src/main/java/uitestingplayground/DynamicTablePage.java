package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;
import java.util.stream.IntStream;

public class DynamicTablePage extends BasePlaygroundPage {
    public DynamicTablePage(Page page) {
        super(page, "http://uitestingplayground.com/dynamictable");
    }


    public Locator table() {
        return page.getByRole(AriaRole.TABLE);
    }

    public Locator chromeCPUParagraph() {
        return page.getByRole(AriaRole.PARAGRAPH).filter(new Locator.FilterOptions().setHasText("Chrome CPU:"));
    }



    public List<Locator> getTableDataRows() {
        Locator dataRowGroup = table().getByRole(AriaRole.ROWGROUP).nth(1);
        return dataRowGroup.getByRole(AriaRole.ROW).all();
    }

    public String getTableValue(String processName, String columnName) {

        int columnIndex = getColumnIndex(columnName);
        int rowIndex = getRowIndexByProcessName(processName);

        Locator cell = getCell(rowIndex, columnIndex);
        return cell.textContent();
    }

    public Locator getCell(int rowIndex, int columnIndex) {
        List<Locator> tableDataRows = getTableDataRows();
        Locator row = tableDataRows.get(rowIndex);
        return row.getByRole(AriaRole.CELL).nth(columnIndex);
    }

    public int getRowIndexByProcessName(String processName) {
        List<Locator> tableDataRows = getTableDataRows();
        return IntStream.range(0, tableDataRows.size())
                .filter(ind -> tableDataRows.get(ind).nth(0).textContent().contains(processName))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
    public int getColumnIndex(String ColumnName) {
        List<Locator> headers = getTableHeaders();

        return IntStream.range(0, headers.size())
                .filter(ind -> headers.get(ind).textContent().contains(ColumnName))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }


    public List<Locator> getTableHeaders() {
        Locator tableHeaderRowGroup = table().getByRole(AriaRole.ROWGROUP).first();
        Locator tableHeaderRow = tableHeaderRowGroup.getByRole(AriaRole.ROW);
        return tableHeaderRow.getByRole(AriaRole.COLUMNHEADER).all();
    }

    public String getParagraphValue() {
        return chromeCPUParagraph().textContent();
    }
}
