package com.example.buitran.banmaytinh;

/**
 * Created by BuiTran on 01/05/2016.
 */
public class TaiKhoan {
    String m_Tk,m_MatKhau,m_Ten,m_email;

    public TaiKhoan() {

    }


    public String getM_Ten() {
        return m_Ten;
    }

    public void setM_Ten(String m_Ten) {
        this.m_Ten = m_Ten;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_Tk() {
        return m_Tk;
    }

    public void setM_Tk(String m_Tk) {
        this.m_Tk = m_Tk;
    }

    public String getM_MatKhau() {
        return m_MatKhau;
    }

    public void setM_MatKhau(String m_MatKhau) {
        this.m_MatKhau = m_MatKhau;
    }

    public void insertTK()
    {

    }

    public TaiKhoan(String m_Tk, String m_MatKhau, String m_Ten, String m_email) {
        this.m_Tk = m_Tk;
        this.m_MatKhau = m_MatKhau;
        this.m_Ten = m_Ten;
        this.m_email = m_email;
    }
}
