export const useLogout = () => {
    const logout = () => {
        localStorage.remove("token");
    };

    return { logout };
};