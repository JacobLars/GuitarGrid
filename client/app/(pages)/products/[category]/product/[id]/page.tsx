"use client";
import { NavBar } from "@/app/components/navbar/NavBar";

export default function ProductPage({
  params,
}: {
  params: { category: string; id: string };
}) {
  console.log(params.category);
  console.log(params.id);
  return (
    <div className="">
      <NavBar />
    </div>
  );
}
