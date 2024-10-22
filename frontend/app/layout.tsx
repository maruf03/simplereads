import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Simplereads",
  description: "Simplereads is a basic Goodreads clone that allows users to post, comment and view book reviews",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className="w-screen h-screen">
        {children}
      </body>
    </html>
  );
}
