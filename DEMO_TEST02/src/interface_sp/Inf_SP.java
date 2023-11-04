package interface_sp;

import model.SanPham;

public interface Inf_SP {

    public int insert_SP(SanPham sp);

    public int update_SP(SanPham sp, String id);

    public int delete_SP(String id);
}
