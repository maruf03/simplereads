import { AuthService } from "@/service/auth.service";

export const useLogin = () => {
    const login = async (email: string, password: string) => {
        const data  = await AuthService.loginUser({ email, password });
        if (data) {
            localStorage.setItem("token", JSON.stringify(data.token));
        }
        return true;
    };

    return { login };
};