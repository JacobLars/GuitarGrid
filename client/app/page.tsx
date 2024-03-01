import { Spinner } from "@nextui-org/react";
import { NavBar } from "./components/navbar/NavBar";
import { Products } from "./components/home/Products";

export default function Home() {
  return (
    <div className="">
      <NavBar />
      <Products />
    </div>
  );
}
