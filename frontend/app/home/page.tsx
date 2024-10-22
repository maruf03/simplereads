import Header from "@/component/header";


const HomePage = () => {
  return (
    <>
    <Header />
    <div className="container mx-auto">
      <h1 className="text-4xl font-bold text-center">Welcome to SimpleReads</h1>
      <p className="text-center">SimpleReads is a simple blog platform built with Next.js and Tailwind CSS.</p>
    </div>
    </>
  );
};

export default HomePage;
