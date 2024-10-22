import axiosInstance from "@/lib/axios";
import { RegisterModel } from "@/model/register.model";
import { LoginModel } from "@/model/login.model";
import { ResponseModel } from "@/model/response.model";
import { UserModel } from "@/model/user.model";

const registerUser = async (userData: RegisterModel) => {
    try {
        const response = await axiosInstance.post<ResponseModel<UserModel>>('/auth/signup', userData);
        console.log('Registration successful:', response.data);
    } catch (error) {
        console.error('Registration failed:', error);
    }
};

const loginUser = async (credentials: LoginModel) => {
    try {
        const response = await axiosInstance.post<ResponseModel<{
            token: string,
            expiresIn: number
        }>>('/auth/login', credentials);
        return response.data.data;
    } catch (error) {
        console.error('Login failed:', error);
    }
};

export const AuthService = {
    registerUser,
    loginUser,
};