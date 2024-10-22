import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL, // use your API base URL here
  timeout: 5000, // example timeout of 5 seconds
  headers: {
    'Content-Type': 'application/json',
  },
});

// List of routes that should not include the token
const excludedRoutes = ['/auth/register', '/auth/login'];

axiosInstance.interceptors.request.use(
  (config) => {
    // Check if the request URL matches an excluded route
    const isExcluded = excludedRoutes.some((route) => config!.url!.includes(route));
    
    if (!isExcluded) {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

export default axiosInstance;