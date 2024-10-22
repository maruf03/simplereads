export interface ResponseModel<T> {
    data: T;
    code: number;
    message: string;
}