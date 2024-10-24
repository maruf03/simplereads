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
      <head>
        <link rel="icon" type="image/png" href="/favicon-48x48.png" sizes="48x48" />
        <link rel="icon" type="image/svg+xml" href="/favicon.svg" />
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png" />
        <link rel="manifest" href="/site.webmanifest" />
      </head>
      <body className="w-screen h-screen">
        {children}
      </body>
    </html>
  );
}
