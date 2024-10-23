import { FlowbiteNavbarTheme, Navbar, NavbarBrand } from "flowbite-react";

const customTheme: FlowbiteNavbarTheme = {
  root: {
    base: "bg-[#f4f1ea] px-2 py-2.5 sm:px-4",
    rounded: {
      on: "rounded",
      off: "",
    },
    bordered: {
      on: "border",
      off: "",
    },
    inner: {
      base: "mx-auto flex flex-wrap items-center justify-between",
      fluid: {
        on: "",
        off: "container",
      },
    },
  },
  brand: {
    base: "flex items-center",
  },
  collapse: {
    base: "w-full md:block md:w-auto",
    list: "mt-4 flex flex-col md:mt-0 md:flex-row md:space-x-8 md:text-sm md:font-medium",
    hidden: {
      on: "hidden",
      off: "",
    },
  },
  link: {
    base: "block py-2 pl-3 pr-4 md:p-0",
    active: {
      on: "bg-cyan-700 text-white dark:text-white md:bg-transparent md:text-cyan-700",
      off: "border-b border-gray-100 text-gray-700 hover:bg-gray-50  md:border-0 md:hover:bg-transparent md:hover:text-cyan-700",
    },
    disabled: {
      on: "text-gray-400 hover:cursor-not-allowed dark:text-gray-600",
      off: "",
    },
  },
  toggle: {
    base: "inline-flex items-center rounded-lg p-2 text-sm text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 md:hidden",
    icon: "h-6 w-6 shrink-0",
  },
};
const Header: React.FC = () => {
  return (
    <Navbar theme={customTheme}>
      <NavbarBrand href="/home">
        <span className="self-center whitespace-nowrap text-4xl text-[#00635D]">
          simple<span className="font-semibold">reads</span>
        </span>
      </NavbarBrand>
    </Navbar>
  );
};  

export default Header;
