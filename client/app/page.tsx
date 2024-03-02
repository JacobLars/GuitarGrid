import { Spinner } from "@nextui-org/react";
import { NavBar } from "./components/navbar/NavBar";
import { Products } from "./components/home/Products";
import { Header } from "./components/home/Header";

export default function Home() {
  return (
    <div className="">
      <Header />
      <NavBar />
      <Products />
    </div>
  );
}
