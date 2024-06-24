import { Link } from "@nextui-org/react";
import React from "react";

export const NavBar = () => {
  return (
    <div>
      <nav className="bg-slate-600 text-white flex flex-row items-center justify-around h-10">
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/"
        >
          <p>Home</p>
        </Link>
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/selection"
        >
          <p>Guitars</p>
        </Link>
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/products/tuners"
        >
          <p>Tuners</p>
        </Link>
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/products/amplifiers"
        >
          <p>Amplifiers</p>
        </Link>
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/products/pickups"
        >
          <p>Pickups</p>
        </Link>
        <Link
          className="hover:bg-slate-700 h-full w-full flex justify-center"
          href="/products/picks"
        >
          <p>Picks</p>
        </Link>
      </nav>
    </div>
  );
};
