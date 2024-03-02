import { Spinner } from "@nextui-org/react";
import { NavBar } from "./components/navbar/NavBar";
import { Products } from "./components/home/Products";

export default function Home() {
  return (
    <div className="">
      <div className="flex flex-col items-center m-5">
        <img className="h-16" src="guitargrid.png"></img>
        <p className="text-2xl">Guitar Grid</p>
      </div>
      <NavBar />
      <Products />
    </div>
  );
}
