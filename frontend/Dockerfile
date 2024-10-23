# Stage 1: Build the Next.js static site using Node.js 20 LTS
FROM node:20-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json (or yarn.lock)
COPY package.json ./
COPY package-lock.json ./

# Install dependencies
RUN npm install

# Copy all source code
COPY . .

# Build the Next.js static site (output to "out" folder)
RUN npm run build

# Stage 2: Serve the static files using Nginx
FROM nginx:alpine

# Copy static files from the builder stage
COPY --from=builder /app/out /usr/share/nginx/html

# Copy custom Nginx configuration (optional)
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 to serve the app
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
