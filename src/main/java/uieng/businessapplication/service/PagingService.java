package uieng.businessapplication.service;

/**
 * @author Dieter Holz
 */
public interface PagingService<DTO> {
    int getTotalCount();

    int getFilteredCount(String filter);

    Page<DTO> getPage(int start, int pageSize, String filter);
}
