"use client";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useRouter } from "next/navigation";
import { Button, Label, TextInput, Alert } from "flowbite-react";
import { useLogin } from "@/hooks/useLogin";

const loginSchema = z.object({
  email: z.string().min(1, "Email is required").email("Invalid email address"),
  password: z.string().min(6, "Password must be at least 6 characters"),
});

type FormData = z.infer<typeof loginSchema>;

const LoginForm = () => {
  const { login } = useLogin();
  const router = useRouter();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>({
    resolver: zodResolver(loginSchema),
  });

  const onSubmit = (data: FormData) => {
    console.log(data);
    // Handle login logic here, e.g., API call
    login(data.email, data.password).then((res) => {
        if (res) {
            router.push("/home");
        }
    });
  };
  return (
    <div className="flex justify-center items-center w-full h-full">
      <form
        className="w-96 bg-white p-6 rounded-xl"
        onSubmit={handleSubmit(onSubmit)}
      >
        <div className="mb-4">
          <Label htmlFor="email" value="Email" />
          <TextInput
            id="email"
            type="email"
            placeholder="name@company.com"
            {...register("email")}
            color={errors.email ? "failure" : ""}
          />
          {errors.email && (
            <Alert color="failure" className="mt-2">
              {errors.email.message?.toString()}
            </Alert>
          )}
        </div>

        <div className="mb-6">
          <Label htmlFor="password" value="Password" />
          <TextInput
            id="password"
            type="password"
            placeholder="••••••••"
            {...register("password")}
            color={errors.password ? "failure" : ""}
          />
          {errors.password && (
            <Alert color="failure" className="mt-2">
              {errors.password.message?.toString()}
            </Alert>
          )}
        </div>

        <Button type="submit" fullSized>
          Login
        </Button>
      </form>
    </div>
  );
};

export default LoginForm;
